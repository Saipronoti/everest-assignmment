namespace FeatureFlagManagement.Entities
{
    public class Override
        {
            public int Id { get; set; } // Primary key
            public string Property1 { get; set; }
            public string Property2 { get; set; }

            // Add the missing properties
            public string FeatureKey { get; set; }
            public string ScopeType { get; set; }
            public string ScopeId { get; set; }
        }
}