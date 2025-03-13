# Sistema de Gerenciamento de Clientes Sea

Uma aplicação Spring Boot para gerenciar clientes com autenticação segura, consulta de endereço via ViaCEP e controle de acesso baseado em roles.

---

## Funcionalidades

- **Controle de Acesso Baseado em Perfis**:  
  - **Admin**: Operações CRUD completas em clientes e gerenciamento de usuários.  
  - **Usuário Padrão**: Acesso apenas de leitura aos clientes.  
- **Integração com ViaCEP**: Preenchimento automático de endereço usando CEP brasileiro.  
- **Validações**: CPF, CEP e restrições de campos.  
- **Segurança**: Hash de senha com BCrypt, Autenticação HTTP Basic.  

---

## Tecnologias

- **Backend**: Spring Boot 3, Hibernate, Spring Security.  
- **Banco de Dados**: MySQL.  
- **Ferramentas**: Lombok, Maven, API RESTful.  

---

