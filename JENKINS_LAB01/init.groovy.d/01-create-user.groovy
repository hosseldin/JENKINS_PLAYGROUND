// Import required Jenkins core classes
import jenkins.model.*
import hudson.security.*

// Get the Jenkins instance
def instance = Jenkins.getInstance()

// Create a new security realm that allows managing users inside Jenkins (not external like LDAP)
def hudsonRealm = new HudsonPrivateSecurityRealm(false)

// Create a new user with username 'devuser' and password 'password123'
hudsonRealm.createAccount("hosa-docker", "1234")

// Set this realm (user system) on Jenkins
instance.setSecurityRealm(hudsonRealm)

// Save the configuration
instance.save()
