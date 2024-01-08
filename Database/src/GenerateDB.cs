using Microsoft.EntityFrameworkCore.Metadata.Conventions;
using Microsoft.EntityFrameworkCore;

namespace Databases {
    public class GenerateDB {

        public static bool GenerateDBByDll(string conexao, Type[] types) {
            var optionsBuilder = TesteConexao.GetOptionsBySGBD(conexao);
            
            var dbContext = new GlobalContext(optionsBuilder) {
                Types = types.ToList()
            };

            var isCreateDatabase = dbContext.Database.EnsureCreated();

            dbContext.Dispose();
            return isCreateDatabase;
        }
    }
}
