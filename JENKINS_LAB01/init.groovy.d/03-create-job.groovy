// Import Jenkins core classes
import jenkins.model.*
import hudson.model.*
import hudson.tasks.Shell
import hudson.plugins.git.*

// Get the main Jenkins instance
def jenkins = Jenkins.getInstance()

// Define a job name
def jobName = "hosa-job01"

// Only create the job if it doesn't already exist
if (jenkins.getItem(jobName) == null) {
    
    // Create a new Freestyle project with the defined name
    def job = jenkins.createProject(FreeStyleProject, jobName)
    
    // Configure Git source (replace with your actual repo URL)
    job.setScm(new GitSCM("https://github.com/hosseldin/CICD_APPS.git"))
    
    // Define shell commands to run in the build step
    def shellBuilder = new Shell("""
        mkdir hello-dir
        echo "Hello World" > hello-dir/hello.txt
    """)
    
    // Add the shell builder to the job's build steps
    job.getBuildersList().add(shellBuilder)

    // Save the job configuration
    job.save()
}
