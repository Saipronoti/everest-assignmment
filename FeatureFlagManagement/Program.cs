using FeatureFlagManagement.Data;
using FeatureFlagManagement.Repositories;
using FeatureFlagManagement.Services;
using Microsoft.EntityFrameworkCore;

var builder = WebApplication.CreateBuilder(args);

// Add services to the container.
builder.Services.AddControllers();
builder.Services.AddDbContext<FeatureFlagContext>(options =>
    options.UseSqlite("Data Source=featureflags.db"));
builder.Services.AddScoped<IFeatureRepository, FeatureRepository>();
builder.Services.AddScoped<FeatureService>();

var app = builder.Build();

// Configure the HTTP request pipeline.
app.UseAuthorization();
app.MapControllers();
app.Run();