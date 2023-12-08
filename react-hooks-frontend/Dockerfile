# Node image as base image (alpine is distribution)
FROM node:17-alpine3.12
WORKDIR /app
ENV PATH /app/node_modules/.bin:$PATH
COPY package.json .
COPY package-lock.json .

# When we build container, run this command before building container
RUN npm install

# Copy the contents of the current directory into the root directory of the image
COPY . .

# Exposing the port 300 (as react listens on 3000)
EXPOSE 3000
CMD ["npm", "start"]