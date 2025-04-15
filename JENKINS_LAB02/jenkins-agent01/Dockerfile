# In this lab, I will use a different approach, I will not use an ready image,
# I will use the official Ubuntu image and install the necessary packages
FROM ubuntu:22.04

# Install necessary packages to run the agent
# What was important to be installed below? The openjdk and openssh
RUN apt-get update && apt-get install -y \
    sudo \
    openssh-server \
    openjdk-17-jdk \
    curl \
    git \
    docker.io \
    net-tools \
    iputils-ping \
    unzip \
    passwd \
    && apt-get clean

# Changes the password of the jenkins user
# Create a new user named 'jenkins' with a home directory and bash shell
RUN useradd -m -d /home/jenkins -s /bin/bash jenkins \
    \
    # Set the password for the 'jenkins' user
    && echo "jenkins:1234" | chpasswd \
    \
    # Add 'jenkins' user to the 'sudo' group to grant admin privileges
    && usermod -aG sudo jenkins \
    \
    # Add Java 17 binaries to the PATH environment variable for the jenkins user
    && echo 'export PATH=$PATH:/usr/local/openjdk-17/bin' >> /home/jenkins/.bashrc \
    \
    # Ensure the jenkins user owns its .bashrc file (fixes permission issues)
    && chown jenkins:jenkins /home/jenkins/.bashrc


# Let's now configure the ssh on the agent node
RUN mkdir -p /var/run/sshd \
    \
    # Create the .ssh directory for the 'jenkins' user
    && mkdir -p /home/jenkins/.ssh \
    \
    # Set correct permissions (only owner can read/write/execute)
    && chmod 700 /home/jenkins/.ssh \
    \
    # Create the authorized_keys file (to store public keys for SSH login)
    && touch /home/jenkins/.ssh/authorized_keys \
    \
    # Set secure permissions for the authorized_keys file
    && chmod 600 /home/jenkins/.ssh/authorized_keys \
    \
    # Change ownership of the entire .ssh folder and its contents to 'jenkins'
    && chown -R jenkins:jenkins /home/jenkins/.ssh

# Start the sshd daemon in the foreground
CMD ["/usr/sbin/sshd", "-D"]
#  the option -D is important because if the main process from the CMD or ENTRYPOINT
# exits, the whole container would stop, but running sshd ensures that the container
# stays up and running even if the main process exits.



# # Allow root login via SSH (again, not recommended for production; use keys!)
# RUN sed -i 's/#PermitRootLogin prohibit-password/PermitRootLogin yes/' /etc/ssh/sshd_config

# # Expose SSH port
# EXPOSE 22
