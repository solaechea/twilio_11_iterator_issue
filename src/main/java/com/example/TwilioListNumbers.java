package com.example;

import com.twilio.base.ResourceSet;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.api.v2010.account.IncomingPhoneNumber;

/**
 * Simple program that lists Incoming Phone Numbers for the configured Twilio account.
 *
 * It expects the environment variables TWILIO_ACCOUNT_SID, TWILIO_KEY_SID, and TWILIO_KEY_SECRET to be set.
 */
public class TwilioListNumbers {
    public static void main(String[] args) {
        String TWILIO_KEY_SID = System.getenv("TWILIO_KEY_SID");
        String TWILIO_KEY_SECRET = System.getenv("TWILIO_KEY_SECRET");
        String TWILIO_ACCOUNT_SID = System.getenv("TWILIO_ACCOUNT_SID");

        if (TWILIO_KEY_SID == null || TWILIO_KEY_SECRET == null || TWILIO_ACCOUNT_SID == null) {
            System.out.println("Hello, World.\n\nTo list Twilio phone numbers, set environment variables TWILIO_ACCOUNT_SID, TWILIO_KEY_SID and TWILIO_KEY_SECRET and run again.");
            System.out.println("Example (PowerShell): $env:TWILIO_ACCOUNT_SID='AC...'; $env:TWILIO_KEY_SID=''; $env:TWILIO_KEY_SECRET=''; mvn compile exec:java");
            return;
        }

        System.out.println("Hello, Twilio! Building client and listing incoming phone numbers for account " + TWILIO_ACCOUNT_SID);

        TwilioRestClient client = new TwilioRestClient.Builder(TWILIO_KEY_SID, TWILIO_KEY_SECRET)
            .accountSid(TWILIO_ACCOUNT_SID)
            .build();

        ResourceSet<IncomingPhoneNumber> numbers = IncomingPhoneNumber.reader().read(client);

        // This will create an infinite loop when using Twilio Java SDK version 11.0.2
        while (numbers.iterator().hasNext()) {
            IncomingPhoneNumber number = numbers.iterator().next();
            System.out.printf("%s  —  %s (sid: %s)\n", number.getPhoneNumber(), number.getFriendlyName(), number.getSid());
        }
    }
}
