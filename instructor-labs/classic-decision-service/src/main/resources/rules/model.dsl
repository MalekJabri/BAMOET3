[condition][]- {field}  {operator}  {value}={field}  {operator}  {value}
[condition][]and=&&
[condition][]or=||
[condition][]is at most=<=
[condition][]any of the following conditions is true :=
[condition][]- It is not true that=!
[condition][]is less than=<
[condition][]is greater than=>
[condition][]is atleast=>=
[condition][]is equal to===
[condition][][Tt]here is an? {entity}=${entity!lc}: {entity!ucfirst}()
[condition][]is not equal to=!=
[condition][]is one of=in
[condition][]is not one of=not in
[condition][]is null=== null
[condition][]is not null=!=null
[condition][]is not empty=!=""
[consequence][]update {entity}=update (${entity})
[consequence][]the name of the rule=drools.getRule().getName()
[condition][]There is result in recommendation=$result:com.ibm.edu.bamoe.labs.model.Result() from $recommendation.result
[condition][]type=type
[condition][]name=name
[condition][]product name=productName
[condition][]recommendation reason=recommendationReason
[condition][]street address=streetAddress
[condition][]There is customer=$customer:com.ibm.edu.bamoe.labs.model.Customer()
[condition][]id=id
[consequence][]set the id of customer to {v1}=$customer.setId({v1});
[condition][]id type=idType
[consequence][]set the id type of customer to {v1}=$customer.setIdType({v1});
[condition][]title=title
[condition][]last name=lastName
[consequence][]set the last name of customer to {v1}=$customer.setLastName({v1});
[condition][]middle name=middleName
[consequence][]set the middle name of customer to {v1}=$customer.setMiddleName({v1});
[condition][]first name=firstName
[consequence][]set the first name of customer to {v1}=$customer.setFirstName({v1});
[condition][]marital status=maritalStatus
[consequence][]set the marital status of customer to {v1}=$customer.setMaritalStatus({v1});
[condition][]annual earned income of the customer=$customer.annualEarnedIncome
[consequence][]set the annual earned income of customer to {v1}=$customer.setAnnualEarnedIncome({v1});
[condition][]date of birth=dateOfBirth
[consequence][]set the date of birth of customer to {v1}=$customer.setDateOfBirth({v1});
[condition][]home phone=homePhone
[consequence][]set the home phone of customer to {v1}=$customer.setHomePhone({v1});
[condition][]work phone=workPhone
[consequence][]set the work phone of customer to {v1}=$customer.setWorkPhone({v1});
[condition][]mobile phone=mobilePhone
[consequence][]set the mobile phone of customer to {v1}=$customer.setMobilePhone({v1});
[condition][]country of residence=countryOfResidence
[consequence][]set the country of residence of customer to {v1}=$customer.setCountryOfResidence({v1});
[condition][]customer address=customerAddress
[consequence][]set the customer address of customer to {v1}=$customer.setCustomerAddress({v1});
[condition][]customer occupation=customerOccupation
[consequence][]set the customer occupation of customer to {v1}=$customer.setCustomerOccupation({v1});
[condition][]email=email
[consequence][]set the email of customer to {v1}=$customer.setEmail({v1});
[condition][]employment status=employmentStatus
[consequence][]set the employment status of customer to {v1}=$customer.setEmploymentStatus({v1});
[condition][]employer name=employerName
[consequence][]set the employer name of customer to {v1}=$customer.setEmployerName({v1});
[condition][]employer address=employerAddress
[consequence][]set the employer address of customer to {v1}=$customer.setEmployerAddress({v1});
[condition][]recommendation=recommendation
[consequence][]set the recommendation of customer to {v1}=$customer.setRecommendation({v1});
[condition][]There is message in recommendation=$message:com.ibm.edu.bamoe.labs.model.Message() from $recommendation.message
[condition][]code=code
[consequence][]set the code of message to {v1}=$message.setCode({v1});
[condition][]text=text
[consequence][]set the text of message to {v1}=$message.setText({v1});
[condition][]param=param
[consequence][]set the param of message to {v1}=$message.setParam({v1});
[condition][]reason=reason
[consequence][]set the reason of message to {v1}=$message.setReason({v1});
[condition][]ruleName=ruleName
[consequence][]set the rule name of message to {v1}=$message.setRuleName({v1});
[condition][]ruleDescription=ruleDescription
[consequence][]set the rule description of message to {v1}=$message.setRuleDescription({v1});
[condition][]status=status
[condition][]message=message
[condition][]There is recommendation for the customer=$recommendation:com.ibm.edu.bamoe.labs.model.Recommendation() from $customer.recommendation
[condition][]id=id
[condition][]action taken=actionTaken
[consequence][]set the action taken of recommendation to {v1}=$recommendation.setActionTaken({v1});
[condition][]result of the recommendation=result
[consequence][]set the result of recommendation to {v1}=$recommendation.setResult(com.ibm.edu.bamoe.labs.model.Result.{v1});
[condition][]message=message
[consequence][]set the message of recommendation to {v1}=$recommendation.setMessage({v1});
[condition][]recommendation status=recommendationStatus
[consequence][]set the recommendation status of recommendation to {v1}=$recommendation.setRecommendationStatus({v1});
[*][]print {message}=System.out.println({message});
[consequence][]add message to the recommendation=com.ibm.edu.bamoe.labs.model.util.Utilities.addMessageToRecommendation($message,$recommendation);
[condition][]result is empty=isResultEmpty()
[condition][]customer age=$customer.getAge()
[consequence][]set the action taken of the recommendation to upper case=$recommendation.setActionTaken($recommendation.actionTaken.toUpperCase())
[condition][]the sum of {v1}  {v2}=com.ibm.edu.bamoe.labs.model.util.Utilities.getSumOfDecValue({v1},$recommendation.{v2})
[condition][]difference between {v1} & {v2}={v1}!=null && ({v1}.doubleValue()-{v2})
[condition][]age=getAge()
[condition][]recommendation not exist=eval($customer.recommendation.size() ==0)
[consequence][]initialize recommendation=$customer.recommendation.add(new com.ibm.edu.bamoe.labs.model.Recommendation());
[consequence][]create message for the recommendation=com.ibm.edu.bamoe.labs.model.Message $message = new com.ibm.edu.bamoe.labs.model.Message();
