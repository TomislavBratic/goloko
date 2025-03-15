FROM php:8.2.12-apache

# Set environment variable for Node.js version
ENV NODE_VERSION=20.10.0

# Update and install necessary packages
RUN apt-get update && \
    apt-get install -y git zip libpng-dev libzip-dev libssl-dev openssh-client nano npm default-mysql-client libonig-dev && \
    docker-php-ext-install mysqli gd zip pdo_mysql mbstring bcmath

# Enable Apache mod_rewrite
RUN a2enmod rewrite

# Install Composer
RUN curl -sS https://getcomposer.org/installer | php -- --install-dir=/usr/local/bin --filename=composer

# Create logs directory and set permissions
RUN mkdir /var/www/logs && \
    chmod 777 /var/www/logs

# Install NVM (Node Version Manager)
RUN curl https://raw.githubusercontent.com/nvm-sh/nvm/v0.39.3/install.sh | bash

# Set environment variable for NVM directory
ENV NVM_DIR=/root/.nvm

# Install Node.js using NVM and set the default version
RUN . "$NVM_DIR/nvm.sh" && \
    nvm install ${NODE_VERSION} && \
    nvm use v${NODE_VERSION} && \
    nvm alias default v${NODE_VERSION}

# Update PATH to include Node.js
ENV PATH="/root/.nvm/versions/node/v${NODE_VERSION}/bin/:${PATH}"

# Install MySQL client again (if needed, already installed earlier)
RUN apt install -y default-mysql-client