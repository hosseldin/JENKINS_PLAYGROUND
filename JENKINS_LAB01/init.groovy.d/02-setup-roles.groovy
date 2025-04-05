// Import core Jenkins classes and the Role Strategy plugin classes
import jenkins.model.*
import hudson.security.*
import com.michelin.cio.hudson.plugins.rolestrategy.*

// Get the Jenkins instance
def instance = Jenkins.getInstance()

// Create a new Role-Based Authorization Strategy
def strategy = new RoleBasedAuthorizationStrategy()

// Apply it to Jenkins (this replaces the default full control for all users)
instance.setAuthorizationStrategy(strategy)

// Define a set of read-only permissions
def permissions = [
  Jenkins.READ,   // Can view Jenkins
  Item.READ,      // Can view jobs
  View.READ       // Can view job views
] as Set

// Create a new role named "read-only" with those permissions
strategy.addRole(RoleBasedAuthorizationStrategy.GLOBAL, new Role("read-only", permissions))

// Assign the "read-only" role to user 'devuser'
strategy.assignRole(
  RoleBasedAuthorizationStrategy.GLOBAL,
  strategy.getRoleMap(RoleBasedAuthorizationStrategy.GLOBAL).getRole("read-only"),
  "devuser"
)

// Save the configuration
instance.save()
