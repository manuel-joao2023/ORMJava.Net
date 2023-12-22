namespace ORMJava.Net.Dto {
    public class TesteConectionDto {
        public string Host { get; set; }
        public string Port { get; set; }
        public string Database { get; set; }
        public string Username { get; set; }
        public string Password { get; set; }
        public string SGBD { get; set; }
        public List<int> DllBytes { get; set; } = new();
        
    }
}
