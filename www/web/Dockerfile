# Use Node.js official image for React
FROM node:20

# Set working directory inside the container
WORKDIR /usr/src/app

# Copy package.json and install dependencies
COPY package.json package-lock.json ./
RUN npm install

# Copy the rest of the React app
COPY . .

# Expose the port the app runs on
EXPOSE 3000

# Start React app
CMD ["npm", "run", "dev"]