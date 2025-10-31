# Twilio List Numbers (example)

This small Maven project demonstrates listing incoming phone numbers using Twilio Java SDK 11.0.2.

Usage

1. Set your Twilio credentials in environment variables (PowerShell):

```powershell
$env:TWILIO_ACCOUNT_SID = 'ACxxxxxxxxxxxxxxxxxxxxxxxxxxxx'
$env:TWILIO_KEY_SECRET = 'key_secret'
$env:TWILIO_KEY_SID = 'key_sip'
```

2. Download dependencies and run:

```powershell
mvn dependency:copy-dependencies
mvn compile exec:java
```

The program will list incoming phone numbers from your Twilio account.

Notes

- Using Twilio Java SDK version 11.0.2 will cause an infinite loop.
- Reverting to Twilio Java SDK version 10.9.2 will fix the issue.

