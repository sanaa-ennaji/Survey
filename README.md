# API REST Survey IT - ITLens

## Overview
**API REST Survey IT** is an IT survey application built using Spring Boot that allows users to participate in and view results of structured IT surveys. The application, **ITLens**, enables survey creation and management, organized into chapters and subchapters containing various types of questions, with RESTful APIs facilitating interaction.
## image sur dockerHube
[https://hub.docker.com/repository/docker/sanaaenng/demo/tags/latest/sha256-0e214a0fb084b1c6de6901c59f8409d915e1c7999e1d469ed56ea4b1e4ac00a1](https://hub.docker.com/r/sanaaenng/demo)
## Features
### Main Features
1. **Survey Participation**: Allows users to respond to open surveys.
2. **Results Consultation**: Provides aggregated results as statistics and percentages for analysis.

### Survey Structure
- **Survey**: Comprises multiple chapters.
- **Chapters**: Contains subchapters with grouped questions.
- **Subchapters**: Each holds one or more questions.
- **Question Types**:
    - **Single Choice**: E.g., "What is your age?"
    - **Multiple Choice**: E.g., "What languages can you read/write?"

### Core Endpoints
- **Survey Management**
    - `POST /surveys` - Create a new survey.
    - `POST /surveys/{surveyId}/chapters` - Add a chapter to a survey.
    - `POST /chapters/{chapterId}/subchapters` - Add a subchapter to a chapter.
    - `POST /subchapters/{subChapterId}/questions` - Add a question to a subchapter.

- **Survey Participation**
    - `POST /surveys/{surveyId}/participate` - Submit a user's survey responses.
    - Example Payload:
      ```json
      {
        "responses": [
          { "questionId": 1, "answerId": "11" },
          { "questionId": 2, "answers": [{"answerId": "25"}, {"answerId": "34"}] }
        ]
      }
      ```

- **Results Consultation**
    - `GET /surveys/{surveyId}/results` - Retrieve survey results.
    - Example Response:
      ```json
      {
        "surveyTitle": "IT Survey 2024",
        "chapters": [
          {
            "title": "Profile",
            "subChapters": [
              {
                "title": "Age",
                "question": "What is your age?",
                "answers": {
                  "18-24": 45,
                  "25-34": 35,
                  "35-44": 15,
                  "Younger than 18": 5
                },
                "totalAnswers": 100
              }
            ]
          }
        ]
      }
      ```

---

## Technologies Used
- **Backend**: Spring Boot
    - **Spring Web**: For exposing the REST API.
    - **Spring Data JPA**: Manages persistence with a relational database (PostgreSQL or MySQL).
    - **Lombok**: Reduces boilerplate code (auto-generates getters, setters, constructors).
    - **MapStruct**: Maps between DTO and entities.
    - **JUnit 5 & Mockito**: For unit and service testing.
    - **@RestControllerAdvice**: Centralized exception handling.
    - **Swagger**: Auto-generates API documentation.
- **Database**: PostgreSQL

---

## Data Model
- **Survey**
    - `id`: Unique identifier
    - `title`: Survey title
    - `description`: Brief description
    - `owner`: Reference to the survey owner

- **SurveyEdition**
    - `id`: Unique identifier
    - `creationDate`: Creation date
    - `startDate`: Launch date
    - `year`: Launch year
    - `survey`: Reference to associated survey

- **Chapter**
    - `id`: Unique identifier
    - `title`: Chapter title
    - `survey`: Reference to associated survey

- **SubChapter**
    - `id`: Unique identifier
    - `title`: Subchapter title
    - `chapter`: Reference to associated chapter

- **Question**
    - `id`: Unique identifier
    - `subChapter`: Reference to associated subchapter
    - `text`: Question text
    - `type`: Question type (SINGLE_CHOICE, MULTIPLE_CHOICE)
    - `answerCount`: Number of responses to the question

- **Answer**
    - `id`: Unique identifier
    - `question`: Reference to associated question
    - `text`: Answer text
    - `selectionCount`: Count of selections for this answer
    - `percentage`: Calculated based on `answerCount` and `selectionCount`

- **Owner**
    - `id`: Unique identifier
    - `name`: Owner's name

---
