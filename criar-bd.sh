# --- Variáveis do Banco de Dados ---
RESOURCE_GROUP="rg-uwbike"
LOCATION="brazilsouth"
SQL_SERVER_NAME="uwbike-sql"
DATABASE_NAME="uwbike-banco"
ADMIN_USER="uwbike"
ADMIN_PASSWORD="SuaSenhaSuperForte123!"
 
# --- Criação dos Recursos ---
echo "Criando Grupo de Recursos..."
az group create --name $RESOURCE_GROUP --location $LOCATION
 
echo "Criando Servidor SQL..."
az sql server create \
    --name $SQL_SERVER_NAME \
    --resource-group $RESOURCE_GROUP \
    --location $LOCATION \
    --admin-user $ADMIN_USER \
    --admin-password "$ADMIN_PASSWORD"
 
echo "Criando Banco de Dados..."
az sql db create \
    --resource-group $RESOURCE_GROUP \
    --server $SQL_SERVER_NAME \
    --name $DATABASE_NAME \
    --service-objective S0
 
echo "Configurando firewall para serviços da Azure..."
az sql server firewall-rule create \
    --resource-group $RESOURCE_GROUP \
    --server $SQL_SERVER_NAME \
    --name "AllowAzureServices" \
    --start-ip-address "0.0.0.0" \
    --end-ip-address "255.255.255.255"
 