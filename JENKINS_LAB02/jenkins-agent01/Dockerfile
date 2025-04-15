# Jenkins Image for the Jenkins Agent
FROM jenkins/inbound-agent:latest-jdk11

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

# Create SSH directory and configure
RUN mkdir /var/run/sshd

# Optionally set root password (for debugging; not recommended in production)
RUN echo "root:1234" | chpasswd

# Allow root login via SSH (again, not recommended for production; use keys!)
RUN sed -i 's/#PermitRootLogin prohibit-password/PermitRootLogin yes/' /etc/ssh/sshd_config

# Expose SSH port
EXPOSE 22

# Start the SSH service
CMD ["/usr/sbin/sshd", "-D"]







# Copy the list of plugins into the container
# Jenkins will use this list to install the specified plugins
# COPY --chown=jenkins:jenkins plugins.txt /usr/share/jenkins/ref/plugins.txt

# Install all plugins listed in plugins.txt using the Jenkins plugin CLI feature
# RUN jenkins-plugin-cli --plugin-file /usr/share/jenkins/ref/plugins.txt

# Copy Groovy init scripts into Jenkins initialization directory
# These scripts are automatically executed the first time Jenkins starts
# COPY --chown=jenkins:jenkins init.groovy.d/ /usr/share/jenkins/ref/init.groovy.d/