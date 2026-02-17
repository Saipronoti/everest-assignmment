using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace FeatureFlagManagement.Entities
{
    [Table("features")]
    public class Feature
    {
        [Key]
        [Column("feature_key")]
        public string Key { get; set; }

        [Column("default_enabled")]
        public bool DefaultEnabled { get; set; }

        [Column("description")]
        public string Description { get; set; }
    }
}