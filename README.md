################# BUILD Process########################

####Build with profile - npmbuild###########

Run command "mvn clean package -Pnpmbuild"  
  -This command will download node js software  
  -Perform npm build for front-end angular project   
  -Create static folder in ${baseDirectory}/resources  
  -Copy front-end resources to static folder.  
  -Clean target directory  
  -package latest war file  


####Build with out any profile ###########
 -From command line, navigate to front-end folder  
 -Run "npm install"  
 -Run "ng build"    
 -Run command "mvn package"
 -launch the war in a server  
 -refresh src/main/resources/static  
 -run on server in eclipse  