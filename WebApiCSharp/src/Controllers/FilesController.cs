using Databases;
using Microsoft.AspNetCore.Mvc;
using Newtonsoft.Json;
using ORMJava.Net.Dto;
using System.IO.Compression;
using System.Reflection;

namespace ORMJava.Net.Controllers {
    [ApiController]
    [Route("[controller]")]
    public class FilesController : ControllerBase {

        
        [HttpPost(nameof(DllContent))]
        public ActionResult DllContent([FromBody] List<int> fileBytes) {
            if (fileBytes == null || fileBytes.Count == 0) {
                return BadRequest();
            }
            List<string> classes = new();

            Type[] types = GetTypesByList(fileBytes);

            foreach (var type in types) {
                classes.Add(type.Name);
            }

            return Ok(classes);
        }

        [HttpPost(nameof(GenerateDatabase))]
        public ActionResult GenerateDatabase([FromBody] TesteConectionDto generateDTO) {
            if (generateDTO == null  || generateDTO.DllBytes.Count == 0) {
                return BadRequest();
            }
            var types = GetTypesByList(generateDTO.DllBytes);
            var resultado = Refactor(generateDTO);

            return Ok(GenerateDB.GenerateDBByDll(resultado, types));
        }
        
        [HttpPost(nameof(GenerateDatabaseByJar))]
        public async Task<ActionResult> GenerateDatabaseByJar([FromBody] TesteConectionDto generateDTO) {
            if (generateDTO == null  || generateDTO.DllBytes.Count == 0) {
                return BadRequest();
            }
            
            var diretorioDestino = @"Files";

            List<string> classes = GetClassesByBytes(generateDTO,diretorioDestino);

            var resultado = Refactor(generateDTO);
            var types = GetTypesByClass(classes);
           
            var result = GenerateDB.GenerateDBByDll(resultado, types);
            await Task.Delay(2000);

            if (result) {
                Directory.Delete(diretorioDestino, true);
            }
            return Ok(result);
        }

        private static Type[] GetTypesByList(List<int> fileBytes) {
            byte[] bytes = fileBytes.Select(b => (byte)b).ToArray();
            
            Assembly assembly = Assembly.Load(bytes);

           return assembly.GetTypes().Where(x => x.IsClass && !x.IsAbstract && !x.IsEnum && !x.IsInterface && !x.IsSealed).ToArray();
        }
       
        private static Type[] GetTypesByClass(List<string> classes) {
            Type[] temp = new Type[classes.Count];
            for (int i = 0; i < classes.Count; i++) {
                temp[i] = Type.GetType(classes[i]);
            }
            return temp;
        }

        private static string Refactor(TesteConectionDto generateDTO) {
            return JsonConvert.SerializeObject(new {
                generateDTO.Host,
                generateDTO.Port,
                generateDTO.Username,
                generateDTO.SGBD,
                generateDTO.Password,
                generateDTO.Database
            });
        }
        private static List<string> GetClassesByBytes(TesteConectionDto generateDTO, string diretorioDestino) {
            List<string> temp = new();
            using (MemoryStream ms = new(generateDTO.DllBytes.Select(b => (byte)b).ToArray())) {
                using ZipArchive zipArchive = new(ms, ZipArchiveMode.Read);

               
                if (!Directory.Exists(diretorioDestino)) {
                    Directory.CreateDirectory(diretorioDestino);
                }

                foreach (ZipArchiveEntry entry in zipArchive.Entries) {
                    string caminhoCompleto = Path.Combine(diretorioDestino, entry.FullName);
                    entry.ExtractToFile(caminhoCompleto, true);
                    temp.Add(entry.FullName.Replace(".cs", ""));
                }
            }
            return temp;
        }
        
    }
}
