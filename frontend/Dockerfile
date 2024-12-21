# Use Node.js image for building the project
FROM node:18 as build

# Set working directory
WORKDIR /frontend

# Copy package files and install dependencies
COPY ./package.json /frontend/
COPY ./package-lock.json /frontend/

RUN npm install

# Copy application code
COPY . ./

# Build the Nuxt.js application
RUN npm run build

# Use Node for serving the app
FROM node:18-slim

# Copy the build files to Nodw
WORKDIR /frontend
COPY --from=build /frontend/.output ./

# Expose the application port
EXPOSE 3000

CMD ["node","/frontend/server/index.mjs"]
