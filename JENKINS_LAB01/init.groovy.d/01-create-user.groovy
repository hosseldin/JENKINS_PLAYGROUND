// Import required Jenkins core classes
import jenkins.model.*
import hudson.security.*

// Get the Jenkins instance
def instance = Jenkins.getInstance()

// Skip setup wizard
instance.setInstallState(InstallState.INITIAL_SETUP_COMPLETED)

// Create a new security realm that allows managing users inside Jenkins (not external like LDAP)
def hudsonRealm = new HudsonPrivateSecurityRealm(false)

// Create a new user with username 'hosa-docker' and password '1234'
hudsonRealm.createAccount("hosa01", "1234")

// Set this realm (user system) on Jenkins
instance.setSecurityRealm(hudsonRealm)

// Use Matrix Authorization Strategy
def strategy = new GlobalMatrixAuthorizationStrategy()

// Grant Overall/Administer permission to the user 'hosa01'
strategy.add(Jenkins.ADMINISTER, "hosa01")

// Apply the authorization strategy
instance.setAuthorizationStrategy(strategy)

// Save the Jenkins configuration changes to disk
instance.save()
