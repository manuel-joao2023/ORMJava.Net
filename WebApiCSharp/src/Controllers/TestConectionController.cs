using Databases;
using Microsoft.AspNetCore.Mvc;
using Newtonsoft.Json;
using ORMJava.Net.Dto;

namespace ORMJava.Net.Controllers {
    [ApiController]
    [Route("[controller]")]
    public class TestConectionController : ControllerBase {

        [HttpPost]
        public async Task<ActionResult> TestConection([FromBody] TesteConectionDto conection) {
            if (conection == null) {
                return BadRequest();
            }
            var resultado = JsonConvert.SerializeObject(conection);
            return Ok(await TesteConexao.TestesConexao(resultado));
        }


    }
}
