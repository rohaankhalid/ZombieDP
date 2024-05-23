## Design Problem

It is the year 2020, and the zombie apocalypse has been terrorizing the world for 2 years now. You are the computer scientist in a team of scientists trying to identify the different types of zombies and their weaknesses. You want to be able to search for a type of zombie, and have the program return that zombie’s weakness. You also want to be able to do the search query as quickly as possible, as there are a constantly-growing number of zombie types.


## Clarifications or Questions

- Are zombie types unique, or can there be multiple zombies with the same type but different weaknesses?
- Should the database support updates to weaknesses if new information is discovered?
- Is thread safety a concern? Will multiple threads be accessing and modifying the zombie database concurrently?
- Should there be any validation on the zombie types and weaknesses (e.g., non-empty strings)?

## Design Decisions and Assumptions

- **Data Structure:** A HashMap is used to store zombie types and their corresponding weaknesses for efficient O(1) average-time complexity for both insertion and lookup.
- **Error Handling:** Standard exceptions are used to handle specific errors such as non-existent zombie types.
- **Input Validation:** Both zombie types and weaknesses are validated to be non-empty strings.
- **Case Sensitivity:** The implementation assumes that zombie types are case-sensitive (e.g., "Runner" and "runner" would be considered different types).
- **Extensibility:**  The design allows easy extension to support additional functionalities like updating weaknesses, removing zombies, or retrieving all zombie types.