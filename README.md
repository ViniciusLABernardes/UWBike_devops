# UWBike
## Sistema de Mapeamento de Motos nos Pátios da Mottu com ESP32 + UWB


# Integrantes:
 - Vinicius Leandro de Araujo Bernardes RM554728 TURMA 2TDSPY
 - Edvan Davi Murilo Santos do Nascimento RM554733 TURMA 2TDSPZ
- Rafael Romanini de Oliveira RM554637 TURMA 2TDSPZ

# Link do vídeo(sprint 4): https://youtu.be/2cB2ft1rWos
### O Sistema atualmente conta com:
#### - Gerenciamento de motos(cadastro/atualização/leitura de dados e remoção);
#### - Gerenciamento de pátios(cadastro/atualização/leitura de dados e remoção);
#### - Gerenciamento de motos no pátio(cadastro/atualização/leitura de dados);
#### - Gerenciamento de âncoras do pátio(cadastro/atualização/leitura de dados e remoção)

## 💡 Objetivo
Desenvolver uma aplicação que:
- Comunique-se com ESP32 via rede/local.
- Receba coordenadas precisas de localização.
- Mapeie em tempo real a posição das motos nos pátios.


## ⚙️ Etapas para rodar o projeto:
### 1 - Rode o script criar-bd.sh (configure-o como queira ou deixe as credenciais como estão).
### 2 - Rode o script script.bd.sql no banco de dados criado na azure
### 3 - Rode o script criar-web-app.sh (configure-o como queira ou deixe as credenciais como estão).
### 4 - Rode o script clonar-projeto.sh
### 5 - Acesse o link gerado pelo azure Web app para a aplicação e teste as funcionalidades pelo navegador assim como foram feitas nos prints demonstrativos

## Prints demonstrativos:

### 1 - Login
- para se logar utilize uma das contas colocadas abaixo do formulário ou pegue na migration 5 nos inserts da tb_login
<img width="1919" height="1079" alt="login" src="https://github.com/user-attachments/assets/4501917d-f8d5-428f-972d-c8f52c997732" />

### 2 - Home/Gerenciar motos
- esta é a pagina inicial, onde você ira ver todas as motos registradas no pátio em que você(funcionario) se encontra, além de um botão de adicionar moto, e botões de editar/excluir moto. A principal funcionalidade é o localizar motos.
<img width="1919" height="1079" alt="home" src="https://github.com/user-attachments/assets/3b008998-0d25-49f7-b475-5c2de1ff1c96" />

### 3 - Localizar moto
- coloque o id da moto desejada, o id do pátio que se encontra, mais 3 valores simulando distâncias entre a moto e os 3 esp32
<img width="1919" height="1079" alt="localizar-moto" src="https://github.com/user-attachments/assets/5ffaaf90-283b-44e6-a7ac-f8b229f11508" />

### 4 - Adicionar moto
<img width="1919" height="1079" alt="cadastrar-moto" src="https://github.com/user-attachments/assets/a76defa2-bc2e-4487-a6ec-e2c706e60814" />

### 5 - Editar moto
<img width="1919" height="1071" alt="editar-moto" src="https://github.com/user-attachments/assets/a6b36832-4c11-4a73-99ff-681cd560fe51" />

### 6 - Gerenciar funcionários
- para acessar esta página, somente se logando com credenciais de um funcionário Gerente
   <img width="1919" height="1079" alt="gerenciar-funcionarios" src="https://github.com/user-attachments/assets/9fe1c884-2790-4773-ae80-06947673f01a" />
   
### 7 - Adicionar funcionário
<img width="1919" height="1079" alt="cadastro-funcio" src="https://github.com/user-attachments/assets/6b8f8944-571a-4a12-b4ab-78042df82df0" />

### 8 - Editar funcionário
<img width="1919" height="1079" alt="editar-funcionario" src="https://github.com/user-attachments/assets/8584371d-a7d9-4b09-997c-4c263cbfaca8" />

### 9 - Gerenciar Âncoras
- para acessar esta página, somente se logando com credenciais de um funcionário Gerente
<img width="1919" height="1079" alt="gerenciar-ancoras" src="https://github.com/user-attachments/assets/22f7965d-c397-4d72-bd15-9cc39e2ab41d" />

### 10 - Adicionar âncora
<img width="1919" height="1079" alt="cadastrar-ancora" src="https://github.com/user-attachments/assets/5af72aac-5333-4316-b569-2bbe4eeb2fe0" />

### 11 - Editar âncora
<img width="1916" height="1079" alt="editar-ancora" src="https://github.com/user-attachments/assets/7e4d893b-a30f-4416-805e-003b6a261788" />

### 12 - Gerenciar Pátios
- para acessar esta página, somente se logando com credenciais de um funcionário Gerente
<img width="1919" height="1079" alt="gerenciar-patio" src="https://github.com/user-attachments/assets/d86ca1c5-d56e-4678-8e97-193edece312e" />

### 13 - Adicionar pátio
<img width="1919" height="1079" alt="adicionar-patio" src="https://github.com/user-attachments/assets/740b1c56-9254-49f5-8957-26b8d4ed046f" />

### 14 - Editar pátio
<img width="1919" height="1079" alt="editar-patio" src="https://github.com/user-attachments/assets/3e05e276-ab27-40e4-9904-3726ea02c5ed" />


## Spring initialzr
<img width="1919" height="1029" alt="springintialzr" src="https://github.com/user-attachments/assets/9b427bb1-a9dd-4ba0-9a9b-ecf204063f4b" />
