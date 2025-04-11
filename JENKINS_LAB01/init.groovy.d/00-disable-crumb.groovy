import jenkins.model.Jenkins
import hudson.security.csrf.DefaultCrumbIssuer

// Get the Jenkins instance
def instance = Jenkins.getInstance()

// Disable crumb issuer (CSRF protection)
instance.setCrumbIssuer(null)

// Save configuration
instance.save()
