# 🏥 history-wise-backend

🌟 Visão Geral
O Serviço de Histórico é responsável por armazenar todas as consultas anteriores dos pacientes, incluindo detalhes sobre diagnósticos, medicação prescrita e sintomas. Ele permite que as consultas realizadas ou canceladas sejam registradas e vinculadas a informações sobre o tratamento médico, facilitando o acompanhamento contínuo da saúde dos pacientes. Esse serviço garante que o histórico médico seja completo e acessível para médicos e outros profissionais de saúde, proporcionando um relatório completo sobre o estado do paciente ao longo do tempo.

---

### **Esquema de Banco de Dados 🗃️**
![History Service Database Diagram](https://github.com/user-attachments/assets/3499e837-e99e-417e-bd27-2e44241394d0)

### **Boas Práticas na Modelagem e Design**

  #### **1. Estrutura Relacional Clara**
  - As tabelas estão organizadas para permitir **relacionamentos claros** entre as consultas, diagnósticos, sintomas, e prescrições, garantindo uma **estrutura relacional eficiente** para consultas rápidas e integradas.
  - O uso de **chaves estrangeiras** entre as tabelas **`PreviousConsultations`**, **`Diagnostics`**, **`Symptoms`**, e **`PrescriptionDetails`** garante a **integridade referencial** dos dados, facilitando consultas com múltiplos relacionamentos entre as tabelas.

  #### **2. Histórico Completo e Detalhado**
  - Cada **consulta** no histórico contém não só a informação básica de quando a consulta foi realizada, mas também os **diagnósticos médicos** e **prescrições**, permitindo um **acompanhamento detalhado** do paciente ao longo do tempo.

  #### **3. Flexibilidade das tabelas**
  - A tabela **`Symptoms`**, por exemplo, permite que **sintomas** sejam escolhidos de um conjunto predefinido, mas pode ser facilmente **expandida** para incluir mais sintomas ou condições conforme necessário, garantindo a **flexibilidade** do sistema e ao mesmo tempo economia de tempo, caso seja algo simples já cadastrado no banco.
