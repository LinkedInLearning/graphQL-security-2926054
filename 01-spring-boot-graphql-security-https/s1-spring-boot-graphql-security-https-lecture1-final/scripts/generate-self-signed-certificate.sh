#!/bin/bash

keytool -genkeypair -alias graphql -keyalg RSA -keysize 2048 -storetype PKCS12 -keystore graphql.p12 -validity 3650