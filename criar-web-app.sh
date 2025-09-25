set -e
# VARIÁVEIS
RG="rg-uwbike"
LOCATION="brazilsouth"               
PLAN="planoServico-free"             
SKU="F1"                             
WEBAPP="UWBike"            
RUNTIME="JAVA:21:Tomcat:10.1"         
INSIGHTS="AppInsights-$WEBAPP"       


# CRIANDO PLANO DE SERVIÇO (FREE)

az appservice plan create \
  --name $PLAN \
  --resource-group $RG \
  --sku $SKU \
  --location $LOCATION \

# CRIANDO WEB APP

az webapp create \
  --resource-group $RG \
  --plan $PLAN \
  --name $WEBAPP \
  --runtime "$RUNTIME" \
  --deployment-local-git


# CONFIGURANDO VARIÁVEIS DE AMBIENTE

az webapp config appsettings set \
  --resource-group $RG \
  --name $WEBAPP \
  --settings \
  DB_USER="uwbike" \
  DB_PASSWORD="SuaSenhaSuperForte123!" \
  DB_URL="jdbc:sqlserver://uwbike-sql.database.windows.net:1433;database=uwbike-banco" \
  DB_DRIVER="com.microsoft.sqlserver.jdbc.SQLServerDriver" \
  DB_DIALECT="org.hibernate.dialect.SQLServerDialect"


# CRIANDO APPLICATION INSIGHTS

az monitor app-insights component create \
  --app $INSIGHTS \
  --location $LOCATION \
  --resource-group $RG


# VINCULANDO INSIGHTS AO WEB APP

az webapp config appsettings set \
  --resource-group $RG \
  --name $WEBAPP \
  --settings \
  "APPINSIGHTS_INSTRUMENTATIONKEY=$(az monitor app-insights component show --app $INSIGHTS --resource-group $RG --query instrumentationKey -o tsv)" \
  "APPLICATIONINSIGHTS_CONNECTION_STRING=$(az monitor app-insights component show --app $INSIGHTS --resource-group $RG --query connectionString -o tsv)" \
  "ApplicationInsightsAgent_EXTENSION_VERSION=~3"


