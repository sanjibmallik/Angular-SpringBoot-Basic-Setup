################# BUILD Process ########################  

#### Build with profile - npmbuild###########  

Run command "mvn clean package -Pnpmbuild"  from project location -Angular-SpringBoot-Basic-Setup (demo) 
  -This command will also download node js software  
  -First build willtake longer. Subsequent builds will be faster
  -Perform npm build for front-end angular project   
  -package latest war file 
  -launch the war in a server    
  -Test at http://localhost:8080/demo 


#### Build with out any profile ###########  
 -From command line, navigate to front-end folder  
 -Will need node and npm already installed.
 -Run "npm install"  
 -Run "ng build"    
 -Run command "mvn package"  from project location -Angular-SpringBoot-Basic-Setup (demo)  
 -launch the war in a server    
 -Test at http://localhost:8080/demo

 
#### Using 4200 ###########  
During local development can also launch locally angular on 4200 
using  
"npm start"  
from front-end folder 
And java server using Run As > Spring Boot app.
-Test at http://localhost:4200/demo

#### Eclipse Notes ###########  
Turn off Validations using Eclipse>Preferences>validations>Suspend All validators
After importing as a maven project in eclipse right click on project and do a Maven>Update Project
