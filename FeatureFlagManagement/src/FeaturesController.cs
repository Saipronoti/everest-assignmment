using FeatureFlagManagement.Services;
using Microsoft.AspNetCore.Mvc;

namespace FeatureFlagManagement.Controllers
{
    [ApiController]
    [Route("api/[controller]")]
    public class FeaturesController : ControllerBase
    {
        private readonly FeatureService _featureService;

        public FeaturesController(FeatureService featureService)
        {
            _featureService = featureService;
        }

        [HttpGet("{featureKey}/enabled")]
        public async Task<IActionResult> IsFeatureEnabled(string featureKey, [FromQuery] string scopeType, [FromQuery] string scopeId)
        {
            var isEnabled = await _featureService.IsFeatureEnabledAsync(featureKey, scopeType, scopeId);
            return Ok(isEnabled);
        }
    }
}