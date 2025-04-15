# Use the official Jenkins LTS (Long-Term Support) Docker image as the base
FROM jenkins/jenkins:lts

USER root

# Install Docker CLI
RUN apt-get update && apt-get install -y \
    openssh-server \
    curl \
    git \
    docker.io \
    vim \
    net-tools \
    iputils-ping \
    unzip \
    sudo \
    passwd \
    && apt-get clean

RUN usermod -aG docker jenkins

USER jenkins









# Copy the list of plugins into the container
# Jenkins will use this list to install the specified plugins
# COPY --chown=jenkins:jenkins plugins.txt /usr/share/jenkins/ref/plugins.txt

# Install all plugins listed in plugins.txt using the Jenkins plugin CLI feature
# RUN jenkins-plugin-cli --plugin-file /usr/share/jenkins/ref/plugins.txt

# Copy Groovy init scripts into Jenkins initialization directory
# These scripts are automatically executed the first time Jenkins starts
# COPY --chown=jenkins:jenkins init.groovy.d/ /usr/share/jenkins/ref/init.groovy.d/
