using FeatureFlagManagement.Entities;
using FeatureFlagManagement.Repositories;

namespace FeatureFlagManagement.Services
{
    public class FeatureService
    {
        private readonly IFeatureRepository _featureRepository;

        public FeatureService(IFeatureRepository featureRepository)
        {
            _featureRepository = featureRepository;
        }

        public async Task<bool> IsFeatureEnabledAsync(string featureKey, string scopeType, string scopeId)
        {
            // Check overrides (mocked for simplicity)
            // Add logic to query overrides table here

            // Check default feature state
            var feature = await _featureRepository.GetFeatureAsync(featureKey);
            return feature?.DefaultEnabled ?? false;
        }
    }
}