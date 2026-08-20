package com.techquiz.app.config;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBInitializer {

    private static final Logger logger =
            Logger.getLogger(DBInitializer.class.getName());

    public static boolean initialize() {
        Connection connection = DBConnection.getConnection();

        if (connection == null) {
            logger.severe("Database connection is null.");
            return false;
        }

        try (Statement statement = connection.createStatement()) {

            createUsersTable(statement);
            createExamTable(statement);
            createPerformanceTable(statement);
            createQuestionsTable(statement);

            logger.info("Database initialization completed successfully.");

            return true;

        } catch (SQLException e) {

            logger.log(
                    Level.SEVERE,
                    "Failed to initialize database.",
                    e
            );

            return false;
        }
    }

    public static boolean destroy() {
        Connection connection = DBConnection.getConnection();

        if (connection == null) {
            logger.severe("Database connection is null.");
            return false;
        }

        try (Statement statement = connection.createStatement()) {

            deleteUsersTable(statement);
            deleteExamTable(statement);
            deletePerformanceTable(statement);
            deleteQuestionsTable(statement);

            logger.info("Database destroyed successfully.");

            return true;

        } catch (SQLException e) {

            logger.log(
                    Level.SEVERE,
                    "Failed to initialize database.",
                    e
            );

            return false;
        }
    }

    private static void deleteUsersTable(Statement statement)
            throws SQLException {

        String sql = """
                DROP TABLE IF EXISTS users
                """;

        statement.executeUpdate(sql);

        logger.info("users table deleted successfully.");
    }

    private static void deleteExamTable(Statement statement)
            throws SQLException {

        String sql = """
                DROP TABLE IF EXISTS exams
                """;

        statement.executeUpdate(sql);

        logger.info("exam table deleted successfully.");
    }

    private static void deletePerformanceTable(Statement statement)
            throws SQLException {

        String sql = """
                DROP TABLE IF EXISTS performances
                """;

        statement.executeUpdate(sql);

        logger.info("performance table deleted successfully.");
    }

    private static void deleteQuestionsTable(Statement statement)
            throws SQLException {

        String sql = """
                DROP TABLE IF EXISTS questions
                """;

        statement.executeUpdate(sql);

        logger.info("questions ");
    }

    private static void createUsersTable(Statement statement)
            throws SQLException {

        String sql = """
                CREATE TABLE IF NOT EXISTS users (
                    userid VARCHAR(50) PRIMARY KEY,
                    password VARCHAR(255) NOT NULL,
                    usertype VARCHAR(20) NOT NULL
                )
                """;

        statement.executeUpdate(sql);

        logger.info("users table checked/created.");
    }

    private static void createExamTable(Statement statement)
            throws SQLException {

        String sql = """
                CREATE TABLE IF NOT EXISTS exam (
                    examid VARCHAR(50) PRIMARY KEY,
                    language VARCHAR(100) NOT NULL,
                    total_question INT NOT NULL
                )
                """;

        statement.executeUpdate(sql);

        logger.info("exam table checked/created.");
    }

    private static void createPerformanceTable(Statement statement)
            throws SQLException {

        String sql = """
                CREATE TABLE IF NOT EXISTS performance (
                    userid VARCHAR(50) NOT NULL,
                    examid VARCHAR(50) NOT NULL,
                    `right` INT NOT NULL DEFAULT 0,
                    `wrong` INT NOT NULL DEFAULT 0,
                    unattempted INT NOT NULL DEFAULT 0,
                    percentage DECIMAL(5,2) NOT NULL DEFAULT 0.00,
                    language VARCHAR(100) NOT NULL,

                    PRIMARY KEY (userid, examid),

                    FOREIGN KEY (userid)
                        REFERENCES users(userid),

                    FOREIGN KEY (examid)
                        REFERENCES exam(examid)
                )
                """;

        statement.executeUpdate(sql);

        logger.info("performance table checked/created.");
    }

    private static void createQuestionsTable(Statement statement)
            throws SQLException {

        String sql = """
                CREATE TABLE IF NOT EXISTS questions (
                    examid VARCHAR(50) NOT NULL,
                    qno INT NOT NULL,
                    question TEXT NOT NULL,
                    answer1 VARCHAR(500) NOT NULL,
                    answer2 VARCHAR(500) NOT NULL,
                    answer3 VARCHAR(500) NOT NULL,
                    answer4 VARCHAR(500) NOT NULL,
                    correct_answer VARCHAR(500) NOT NULL,
                    language VARCHAR(100) NOT NULL,

                    PRIMARY KEY (examid, qno),

                    FOREIGN KEY (examid)
                        REFERENCES exam(examid)
                        ON DELETE CASCADE
                )
                """;

        statement.executeUpdate(sql);

        logger.info("questions table checked/created.");
    }
}