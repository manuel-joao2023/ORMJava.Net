using Microsoft.EntityFrameworkCore;
using System.Reflection;

namespace Databases {
    public class GlobalContext : DbContext {
        public List<Type> Types { get; set; } = new();
        public GlobalContext(DbContextOptions<GlobalContext> options)
            : base(options) {
        }
        protected override void OnModelCreating(ModelBuilder modelBuilder) {
            base.OnModelCreating(modelBuilder);

            foreach (var type in Types) {
                var data = modelBuilder.Entity(type);
                PropertyInfo property = type.GetProperties().FirstOrDefault(x => string.Equals(x.Name, "id", StringComparison.OrdinalIgnoreCase));
                data.HasKey(property.Name);
            }


        }
    }
}
