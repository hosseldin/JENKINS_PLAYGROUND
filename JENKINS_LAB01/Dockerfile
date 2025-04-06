# Use the official Jenkins LTS (Long-Term Support) Docker image as the base
FROM jenkins/jenkins:lts

# Copy the list of plugins into the container
# Jenkins will use this list to install the specified plugins
COPY plugins.txt /usr/share/jenkins/ref/plugins.txt

# Install all plugins listed in plugins.txt using the Jenkins plugin CLI feature
RUN jenkins-plugin-cli --plugin-file /usr/share/jenkins/ref/plugins.txt

# Copy Groovy init scripts into Jenkins initialization directory
# These scripts are automatically executed the first time Jenkins starts
COPY init.groovy.d/ /usr/share/jenkins/ref/init.groovy.d/
