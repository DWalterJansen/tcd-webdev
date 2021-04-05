# tcd-webdev
![GitHub last commit](https://img.shields.io/github/last-commit/DWalterJansen/desenvolvimento-web-2021-html5ref)
![JDK Version](https://img.shields.io/static/v1?label=JDK&message=11.0.2&color=blue)
![Wildfly Version](https://img.shields.io/static/v1?label=Wildfly&message=22.0.0.Final&color=blue)
![PostgreSQL Version](https://img.shields.io/static/v1?label=PostgreSQL&message=13.2&color=blue)
![PostgreSQL JDBC Version](https://img.shields.io/static/v1?label=PostgreSQL-JDBC&message=42.2.19&color=blue)


# Sumário
1. [Sobre](#sobre)
2. [Criando o projeto](#criando-o-projeto)
3. [Configurando o projeto](#configurando-o-projeto) 


## Sobre

## Criando o projeto
> [!IMPORTANT]
> Requisitos: NetBeans e Wildfly
Inicie sua IDE NetBeans e siga os passos:
1. File
2. New Project
3. Step Choose Project:
    1. Selecione "Web Application"
    2. Next
4. Step Name and Location:
    1. Project Name: "tcd-project"
    2. Project Location: Escolha seu diretório
    3. Group Id: "io.github.anne-david-eike" 
    4. Next
5. Step Settings
    1. Server: WildFly 22.0.0.Final
    2. Java EE Version: JakartaEE 8
    3. Finish
> [!IMPORTANT]
> Caso não tenha a opção "JakartaEE 8", pode selecionar "Java EE 8" e depois será feita a alteração manual

# Configurando o projeto
Localize seu projeto na aba "Projects" à esquerda e siga os passos:
1. Botão-Direito sobre o projeto
    1. Clique
    2. Propriedades
2. Menu de Categories
    1. Run
        1. Java EE Version: Jakarta EE 8 Web
        2. Browser: ... NetBeans Connector
        3. Always perform...: True
    2. License Headers
        1. Use global License: Licença IFNMG

# Configurando o autor
Localize a aba de menus do NetBeans:
1. Tools
2. Templates
3. Settings
    1. user: mude para seu nome e e-mail

# Mudança em arquivos do projeto
Localize o arquivo de gestão do maven (pom.xml) e siga os passos:
1. Altere o *maven.compiler.source* para a versão 11
2. Altere o *maven.compiler.target* para a versão 11
3. Usar a referência de variáveis em *configuration/source*
4. Usar a referência de variáveis em *configuration/target*

# Adicionando dependencia do Jakarta EE 8
Localize as Dependencies na árvore do projeto e siga os passos:
1. Adicione "jakarta.jakartaee-api-8.0.0.jar"
2. Remova "javaee-api-8.0.jar"

# Configurando PostgreSQL
> [!IMPORTANT]
> Requisitos: PostgreSQL
Após a instalação do PostgreSQL siga os passos pelo terminal:
1. Entre como o usuário root
> psql -U postgres
2. Dentro do console psql, crie super usuário
> create role \<user-name\> with login superuser encrypted password \<user-pass\>;
3. Aproveite para criar o Database
> create database \<name-datasource\>
4. Caso exista outro usuário, você pode querer definir esquemas de autorização
> create schema authorization \<user-name\>

# Configurando a fonte de dados no Wildfly
> [!IMPORTANT]
> Requisitos: Wildfly com acesso ao console e feito a etapa [Configurando PostgreSQL](#configurando-postgresql)
> JDBC postgresql v42.2.19
Acesse o console do Wildfly e siga os passos:
1. Menu Deployments
    1. Add (ícone de +)
    2. Faça Upload do arquivo e confirme

2. Menu Configuration
    1. Subsystems
    2. Datasource
    3. Datasources
    4. Add Datasource (ícone de +)
        1. Choose Template: PostgreSQL
        2. Attributes
            1. Name: \<name-datasource\>
            2. JNDI Name: java:/\<name-datasource\>
        3. JDBC Driver
            1. Driver Name: postgresql-42.2.19.jar
            2. Driver Module Name: org.postgresql
            1. Driver Class Name: org.postgresql.Driver
        4. Connection
            1. Connection URL: jdbc:postgresql://localhost:5432/\<name-datasource\>
            2. User Name: \<user-name\>
            3. Password: \<user-pass\>
            4. Security Domain: (Não coloque nada)
        5. Connection
            1. Test Connection
        6. Review
            1. Close
        > [!NOTE]
        > Provavelmente o Wildfly precisará recarregar

3. Volte ao NetBeans, vá ao arquivo persistence.xml e adicione o código substituindo os nomes com base nos passos anteriores:
    ```xml
    <persistence-unit name="<name-datasource>">
        <jta-data-source>
            java:/<name-datasource>
        </jta-data-source>
        <properties>
            <property
                name="javax.persistence.schema-generation.database.action"
                value="drop-and-create"
            />
        </properties>
    </persistence-unit>
    ```