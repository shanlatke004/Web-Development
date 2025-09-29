# Web-Development
Project Overview
This project was driven by my interest in the banking industry. The concept emerged during the initial project introduction, inspiring the creation of a simulated banking system to manage user accounts, transactions, and financial services.
Key Features
Application Views
The application incorporates seven distinct views to provide a comprehensive user experience:

Login Page: Enables secure user authentication to access personal accounts.
Main Page: Serves as the central hub, allowing users to navigate to transaction history or account details.
Account Information: Displays detailed account data and facilitates transactions such as deposits and withdrawals.
Mortgage: Provides tools for users to explore and manage mortgage-related information.
About Page: Offers an overview of the application and its functionalities.
Transaction List: Presents a tabular view of all user transactions for easy review.

These views ensure varied perspectives on the underlying data model, enhancing usability and accessibility.
Custom Widgets
A key custom widget implemented is the transaction management interface within the transaction list view. This widget enables users to perform deposits, withdrawals, and retrieve mortgage details. Upon completion of a transaction, the data is persisted to a text file, ensuring that the transaction history table dynamically updates to reflect all user activities.
Domain Objects
The application supports the creation and editing of the following domain objects:

Mortgage: Represents loan calculations and management.
Deposit: Handles fund additions to user accounts.
Withdrawal: Manages fund deductions from user accounts.

These objects form the core of the banking simulation, allowing for realistic financial operations.

Challenges and Opportunities for Improvement
One of the most challenging aspects was implementing the transaction list display while ensuring data persistence (e.g., account balances and transaction records) across application sessions. This required careful handling of file I/O operations to maintain state.
For future enhancements, I aim to expand the application's capabilities, such as enabling users to create and manage multiple account types (e.g., checking, savings, or investment accounts), mirroring the diversity found in real-world banking systems.
