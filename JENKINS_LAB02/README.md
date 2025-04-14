
Why You Use Both docker-compose.yml + Dockerfile

Dockerfile → Builds your own custom Jenkins image with pre-installed plugins
docker-compose.yml → Runs that custom Jenkins image with the right ports, volumes, etc.

Why You Need a Dockerfile
You must use a Dockerfile if:

You want to build a custom image, e.g., with pre-installed plugins for Jenkins
You need to copy scripts, configs, or plugin files into the image,
So yes — if all you care about is building the Jenkins image with plugins, just a Dockerfile is fine.





Feature	                                    Dockerfile ✅	            Docker Compose ✅
Build custom image	                      ✅                                    	      ✅ (via Dockerfile)
Define multiple services	            ❌	                                        ✅
Reusable, clean config	                ❌	                                        ✅
Easy dev/test/start	                     ❌	                                        ✅


Goal Breakdown ✅

1. Use Docker image to install Jenkins
2. Pre-install Role-Based Authorization Plugin
3. Auto-create new user
4. Auto-create a "read" role and assign to new user
5. Auto-create Freestyle job that clones private Git repo and writes "Hello World"