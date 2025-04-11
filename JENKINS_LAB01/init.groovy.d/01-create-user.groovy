// Import required Jenkins core classes
import jenkins.model.*
import hudson.security.*

// Get the Jenkins instance
def instance = Jenkins.getInstance()

// Create a new security realm that allows managing users inside Jenkins (not external like LDAP)
def hudsonRealm = new HudsonPrivateSecurityRealm(false)

// Create a new user with username 'hosa-docker' and password '1234'
hudsonRealm.createAccount("hosa01", "1234")

// Set this realm (user system) on Jenkins
instance.setSecurityRealm(hudsonRealm)

// Set the authorization strategy:
// This one gives full control to any logged-in user
// and disables anonymous read access
def strategy = new FullControlOnceLoggedInAuthorizationStrategy()
strategy.setAllowAnonymousRead(false) // Optional: block anonymous users from reading Jenkins

// Apply the authorization strategy to the Jenkins instance
instance.setAuthorizationStrategy(strategy)

// Save the Jenkins configuration changes to disk
instance.save()
