namespace FeatureFlagManagement.Entities
{
    public class Override
    {
        public string FeatureKey { get; set; }
        public string ScopeType { get; set; }
        public string ScopeId { get; set; }
    }
}