using FeatureFlagManagement.Entities;

namespace FeatureFlagManagement.Repositories
{
    public interface IFeatureRepository
    {
        Task<Feature> GetFeatureAsync(string key);
    }
}