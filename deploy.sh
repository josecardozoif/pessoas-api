#!/bin/bash

# Variáveis
PROJETO="pessoa-api"
DESTINO="/var/www/html/api"
JAR_NAME="$PROJETO-1.0.0.jar"

echo "📦 Iniciando build do projeto..."

# Etapa 1: Limpar e empacotar o projeto
mvn clean package -DskipTests

# Verificar se o build foi bem-sucedido
if [ $? -ne 0 ]; then
  echo "❌ Erro ao compilar o projeto."
  exit 1
fi

# Etapa 2: Criar diretório de destino (se não existir)
mkdir -p "$DESTINO"

# Etapa 3: Copiar o .jar gerado para a pasta destino
cp "target/$JAR_NAME" "$DESTINO"

# Etapa 4: (Opcional) Parar e reiniciar um serviço específico, como Tomcat externo
# systemctl restart tomcat

echo "✅ Deploy concluído. Arquivo copiado para: $DESTINO/$JAR_NAME"
