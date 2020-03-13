################# BUILD Process########################

####Build with profile - npmbuild###########

Run command "mvn clean package -Pnpmbuild"  
  -This command will download node js software  
  -First build willtake longer. Subsequent builds will be faster
  -Perform npm build for front-end angular project   
  -package latest war file 
  -launch the war in a server     


####Build with out any profile ###########
 -From command line, navigate to front-end folder  
 -Will need node and npm already installed.
 -Run "npm install"  
 -Run "ng build"    
 -Run command "mvn package"  
 -launch the war in a server    

 
####Using 4200 ###########
During local development can also launch locally angular on 4200 
using
npm start
And java server using Run As > Spring Boot app.