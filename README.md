SSO-with-CAS-example
====================

SSO implementation using CAS (as server) and Spring MVC (as clients).

To check it in action, you have to have a certified tomcat (sample certificate you can find in main directory - the name of the service is "localhost").
http://www.mkyong.com/tomcat/how-to-configure-tomcat-to-support-ssl-or-https/

Add to your hosts file entry which points to 127.0.0.1 and name "tomcat".

Build and run application. Checkout:
https://localhost:8443/app1/home
https://localhost:8443/app2/home
https://localhost:8443/cas/


====================
cas https实践
====================

参考https://github.com/piotrekfus91/SSO-with-CAS-example修改, 里面使用的是波兰语, 感谢piotrekfus91
app user使用InMemoryUserDetailsManager以简化, 减去ldap的配置.
并且支持logout登出后跳转回当前服务


cd E:\open-source\cas\sslconf\

**生成keystore
keytool -genkey -alias serverkey -keyalg RSA -keystore serverKey.keystore
(-keyalg RSA非常重要, 不加默认使用DSA, 只有签名作用, 没有加密作用)
CN:您的名字与姓氏是什么? 
输入localhost, 否则报错java.security.cert.CertificateException: No name matching localhost found
http://java.globinch.com/enterprise-java/security/fix-java-security-certificate-exception-no-matching-localhost-found/

**生成证书
keytool -export -alias serverkey -keystore serverKey.keystore -rfc -file serverKey.cer

**导入证书
默认密码(changeit)
keytool -import -keystore "%JAVA_HOME%/jre/lib/security/cacerts" -storepass changeit -keypass changeit -alias serverkey_cert -file serverKey.cer
需导入证书到受信任的根证书里, 否则会报错
sun.security.provider.certpath.SunCertPathBuilderException: unable to find valid certification path to requested targe
t
http://java.globinch.com/enterprise-java/security/pkix-path-building-failed-validation-sun-security-validatorexception/


显示证书
keytool -list -v -keystore "%JAVA_HOME%\jre\lib\security\cacerts" -storepass changeit -alias serverkey_cert
keytool -list -v -keystore "%JAVA_HOME%\jre\lib\security\cacerts" -storepass changeit > keylist.log


Tomcat server.xml配置
<Connector port="8443" protocol="org.apache.coyote.http11.Http11Protocol"
           maxThreads="150" SSLEnabled="true" scheme="https" secure="true"
           clientAuth="false" sslProtocol="TLS" 
           keystoreFile="E:\open-source\cas\sslconf\serverKey.keystore"
           keystorePass="123456"/>
如果Tomcat在eclipse中使用workspace metadata, 则每次clean server, 都会导致server.xml重新生成,配置失效.
解决方案是对Tomcat安装目录的server.xml进行配置

项目web.xml配置,默认使用ssl

  <!-- default ssl -->
  <security-constraint>
    <!-- Authorization setting for SSL -->
    <web-resource-collection>
      <web-resource-name>SSL</web-resource-name>
      <url-pattern>/*</url-pattern>
    </web-resource-collection>
    <user-data-constraint>
      <transport-guarantee>CONFIDENTIAL</transport-guarantee>
    </user-data-constraint>
  </security-constraint>           
               

