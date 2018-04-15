[![security status](https://qa.meterian.com/badge/gh/bbossola/vulnerability-java-samples/security)](https://qa.meterian.com/report/gh/bbossola/vulnerability-java-samples)
[![stability status](https://qa.meterian.com/badge/gh/bbossola/vulnerability-java-samples/stability)](https://qa.meterian.com/report/gh/bbossola/vulnerability-java-samples) 
_(hey, the low security is intentional here!)_

Sample exploits of common vulnerabilities in Java librarires. Please go to [my blog](https://bbossola.wordpress.com/2018/04/14/remotely-execute-java-code-using-json/) for a detailed explanation!

## how to use this?
You can compile the code using Maven, standard structure: in the `/target` subfolder you will get an executable jar that will run the exploitable server. 

The exploit class is availabile in the `/exploit` subfolder, you can find there the exploit itself (unsurprisingly named Exploit.java) and a super simple Encoder class, that will encode the Exploit code in base64 to be included in the JSON

In the `/curls` folder you will find sample curls to invoke the `list` and `add` REST API, plus the `exploit.sh` and the `exploit.json` file.

Please enjoy and be wary that all these information are publicly available on the internet. This is just a summary post from a cybersecurity practitioner and nothing else. The code provided is for research purposes only.

## credits
https://github.com/mbechler/marshalsec
