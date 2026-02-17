using FeatureFlagManagement.Data;
using FeatureFlagManagement.Entities;
using Microsoft.EntityFrameworkCore;

namespace FeatureFlagManagement.Repositories
{
    public class FeatureRepository : IFeatureRepository
    {
        private readonly FeatureFlagContext _context;

        public FeatureRepository(FeatureFlagContext context)
        {
            _context = context;
        }

        public async Task<Feature> GetFeatureAsync(string key)
        {
            return await _context.Features.FirstOrDefaultAsync(f => f.Key == key);
        }
    }
}