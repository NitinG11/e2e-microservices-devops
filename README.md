# e2e-microservices-devops
a basic microservice prototype with docker and ecs deployment


# to setup connectivity to a private RDS instance , use Ec2 as bastionhost
````
1. Create a RDS instance, in a specified VPC, and not accessible to services outside VPC(private)
2. Create an EC2 instance, allow security group to have inbound rule for your system ip.
3. Modify security group of RDSm, to allow EC2 instance private connection using private IP
4. Use SSH tunneling using command line to connect 
    ssh -i /Users/nitin/Downloads/my-app-bastion-host-kp.pem ec2-user@ec2-54-229-244-44.eu-west-1.compute.amazonaws.com -L 3306:usermanagement.ccb3kc2ruwfa.eu-west-1.rds.amazonaws.com:3306
5. to allow spring boot app to connect to the instance use
    ssh -i /Users/nitin/Downloads/my-app-bastion-host-kp.pem ec2-user@ec2-54-229-244-44.eu-west-1.compute.amazonaws.com -L localhost:3306:usermanagement.ccb3kc2ruwfa.eu-west-1.rds.amazonaws.com:3306
6. from terminal use
    for initial setup
    sudo yum install mysql
    mysql -u root -p  -h usermanagement.ccb3kc2ruwfa.eu-west-1.rds.amazonaws.com
7. to connect using mysql workbench use tcp over ssh
    use ssh pem file to connect to the rds
````


ssh -i /Users/nitin/Downloads/my-app-bastion-host-kp.pem ec2-user@ec2-54-229-244-44.eu-west-1.compute.amazonaws.com -L 3306:usermanagement.ccb3kc2ruwfa.eu-west-1.rds.amazonaws.com:3306




mysql -u root -p  -h usermanagement.ccb3kc2ruwfa.eu-west-1.rds.amazonaws.com



aws ecr get-login-password --region eu-west-1 --profile env | docker login --username AWS --password-stdin 979213071888.dkr.ecr.eu-west-1.amazonaws.com