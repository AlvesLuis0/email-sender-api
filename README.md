![E-mail Sender Banner](.github/banner.png)

<h1 align="center" style="font-weight: bold;">
  Email Sender API 📨
</h1>

<p align="center">
  <a href="#tech">Technologies</a> •
  <a href="#started">Getting Started</a> •
  <a href="#routes">API Endpoints</a> •
  <a href="#colab">Collaborators</a> •
  <a href="#contribute">Contribute</a>
</p>

<p align="center">
  <b>API for sending e-mail</b>
</p>

<h2 id="technologies">💻 Technologies</h2>

- Java
- Spring Boot
- Docker
- RabbitMQ

<h2 id="started">🚀 Getting started</h2>

<h3>Prerequisites</h3>

- [Git](https://git-scm.com)
- [JDK 17](https://openjdk.org/projects/jdk/17/)
- [Maven](https://maven.apache.org/),
- [Docker and Docker Compose](https://docs.docker.com/)

<h3>Cloning</h3>

```bash
git clone https://github.com/alvesluis0/email-sender-api
```

<h3>Config .env variables</h2>

Use the `.env.example` as reference to create your configuration file `.env` with your credentials

```yaml
MAIL_USERNAME=myemail123@example.com
MAIL_PASSWORD=qwer uiop zxcv vbnm
```

<h3>Starting</h3>

How to start your project

```bash
cd email-sender-api
# Make sure you have already created your .env file in the project root
mvn spring-boot:run
```

<h2 id="routes">📍 API Endpoints</h2>

| route                         | description                                          
|-------------------------------|-------------------------------------------------------------------
| <kbd>POST /send-email</kbd>   | send email to someone - [request details](#post-send-email-detail)

<h3 id="post-send-email-detail">POST /send-email</h3>

**REQUEST**
```json
{
  "to": "test@gmail.com",
  "subject": "Testing my API",
  "text": "Hi brooooo"
}
```

<h2 id="colab">🤝 Collaborators</h2>

Special thank you for all people that contributed for this project.

<table>
  <tr>
    <td align="center">
      <a href="https://github.com/alvesluis0">
        <img
          src="https://avatars.githubusercontent.com/u/104936483?v=4"
          width="100px;"
          alt="Alves Luis Profile Picture"
        /><br>
        <sub>
          <b>Alves Luis</b>
        </sub>
      </a>
    </td>
  </tr>
</table>

<h2 id="contribute">📫 Contribute</h2>

1. `git clone https://github.com/alvesluis0/email-sender-api`
2. `git checkout -b feature/NAME`
3. Follow commit patterns
4. Open a Pull Request explaining the problem solved or feature made, if exists, append screenshot of visual modifications and wait for the review!

<h3>Documentations that might help</h3>

[📝 How to create a Pull Request](https://www.atlassian.com/br/git/tutorials/making-a-pull-request)

[💾 Commit pattern](https://gist.github.com/joshbuchea/6f47e86d2510bce28f8e7f42ae84c716)