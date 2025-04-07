# Projeto Blog Pessoal - Backend Spring Boot
**README.md**  
*Projeto Blog Pessoal - Backend Spring Boot*  

---

### **Sobre o Projeto**  
Este projeto faz parte do **Programa Acelera Maker** da empresa **Montreal**, com o objetivo de consolidar conhecimentos em Spring Boot, segurança de APIs, persistência de dados e boas práticas de desenvolvimento. Trata-se de um backend para um sistema de blog pessoal, com funcionalidades de gestão de usuários, postagens, temas e autenticação via JWT.  

---

### **Funcionalidades Principais**  
✅ **Gestão de Usuários**  
- Cadastro, atualização e exclusão de usuários.  
- Login seguro com geração de token JWT.  

✅ **Gestão de Postagens**  
- Criação, atualização e exclusão de postagens.  
- Listagem de postagens com filtros por autor e tema.  

✅ **Gestão de Temas**  
- Criação, atualização e exclusão de temas.  
- Relacionamento 1:N entre temas e postagens.  

✅ **Segurança**  
- Autenticação e autorização com Spring Security.  
- Validação de token JWT em todas as requisições protegidas.  

✅ **Documentação**  
- Endpoints documentados via Swagger/OpenAPI.  

---

### **Tecnologias Utilizadas**  
- **Java 17**  
- **Spring Boot 3.4.4**  
- **Spring Security + JWT**  
- **Spring Data JPA** (Persistência com banco de dados relacional)  
- **Maven** (Gerenciamento de dependências)  
- **SonarQube** (Análise de qualidade de código)  
- **MySQL/PostgreSQL** (Banco de dados)  

---

### **Configuração Inicial**  

#### **1. Clone do Repositório**  
```bash  
git clone https://github.com/igorsantos2102/aceleraMaker.git  
cd aceleraMaker  
```  

#### **2. Configuração do Banco de Dados**  
Atualize o arquivo `application.properties` com suas credenciais do banco:  
```properties  
spring.datasource.url=jdbc:mysql://localhost:3306/blog_pessoal  
spring.datasource.username=seu_usuario  
spring.datasource.password=sua_senha  
spring.jpa.hibernate.ddl-auto=update  
```  

#### **3. Executar o Projeto**  
```bash  
mvn clean install  
mvn spring-boot:run  
```  

---

### **Endpoints da API**  
A API possui endpoints para:  
- **Usuários**: `/api/usuarios`  
- **Postagens**: `/api/postagens`  
- **Temas**: `/api/temas`  
- **Login**: `/api/auth/login`  

A documentação completa está disponível via **Swagger**:  
```  
http://localhost:8080/swagger-ui.html  
```  

---

### **Análise de Qualidade com SonarQube**  
Para garantir a qualidade do código, este projeto está integrado ao **SonarQube**:  

#### **Passos para Análise Local**  
1. Inicie o servidor SonarQube via Docker:  
   ```bash  
   docker run -d --name sonarqube -p 9000:9000 sonarqube  
   ```  
2. Gere um token no SonarQube:  
   - Acesse `http://localhost:9000` com login `admin/admin`.  
   - Navegue até **My Account > Security > Generate Token**.  
3. Execute a análise:  
   ```bash  
   mvn clean install sonar:sonar -Dsonar.login=seu_token  
   ```  

---

### **Testes**  
Execute os testes unitários e de integração:  
```bash  
mvn test  
```  


---

### **Contato**  
Para dúvidas ou sugestões:  
- **LinkedIn**: www.linkedin.com/in/0-igor-santos  
- **Email**: igorsantos36912@gmail.com  

---

**Status do Projeto**  
🚧 Em desenvolvimento como parte do treinamento **Acelera Maker**.  

---

**Nota:**  
Este README será atualizado conforme novas funcionalidades forem implementadas.  
 
