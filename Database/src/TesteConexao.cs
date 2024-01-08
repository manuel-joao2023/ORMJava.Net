using Microsoft.EntityFrameworkCore;
using Newtonsoft.Json;

namespace Databases {
    public class TesteConexao {

        internal static DbContextOptions<GlobalContext> GetOptionsBySGBD(string jsonData) {
            var options = new DbContextOptionsBuilder<GlobalContext>().Options;
            var result = JsonConvert.DeserializeObject<dynamic>(jsonData);
            string conection = DeserialiseConection(result);

            switch (result.SGBD.ToString()) {
                case "Postgres":
                    options = new DbContextOptionsBuilder<GlobalContext>()
                            .UseNpgsql($"{conection}")
                            .Options;
                    break;
                case "Mysql":
                    options = new DbContextOptionsBuilder<GlobalContext>()
                            .UseMySQL($"{conection}")
                            .Options;
                    break;
                case "SQLServer":
                    options = new DbContextOptionsBuilder<GlobalContext>()
                            .UseSqlServer($"{conection}")
                            .Options;
                    break;
                default:
                    //var mongoClient = new MongoClient($"mongodb://{Defs.MONGODB_HOST}:{Defs.MONGODB_PORT}");
                    //var database = mongoClient.GetDatabase(Defs.MONGODB_DATABASE);
                    //Console.WriteLine("Conexão com MongoDB estabelecida com sucesso.");
                    break;

            }
            return options;
        }
        public static async Task<bool> TestesConexao(string jsonData) {
            var options = GetOptionsBySGBD(jsonData);
            using var context = new GlobalContext(options);
            return await context.Database.CanConnectAsync();
        }

        private static string DeserialiseConection(dynamic data) {
            return data.SGBD.ToString() switch {
                "SQLServer" or "Mysql" or "Postgres" => (string)(@"" + (data.SGBD.ToString() == "Postgres" ? "Host=" + data.Host.ToString() : "Server=" + data.Host.ToString()) + (data.SGBD == "SQLServer" ? ",Port=" + data.Port.ToString() : ";Port=" + data.Port.ToString()) + ";Database=" + data.Database.ToString() + (data.SGBD.ToString() == "Postgres" ? ";Username=" + data.Username.ToString() : ";USER=" + data.Username.ToString()) + ";Password=" + data.Password.ToString() + ";" + @""),
                _ => (string)(@"{""" + data.SGBD.ToString() + @""": ""mongodb://" + data.Host.ToString() + ":" + data.Port.ToString() + @""),
            };
        }
    }
}
