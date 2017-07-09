
#!/bin/bash
//mail to: "satyapriya.das@cognizant.com", subject:"SUCCESS: ${currentBuild.fullDisplayName}", body: "The pipeline ${currentBuild.fullDisplayName} completed successfully."
mail -s “Build Step Completed Successfully” satyapriya.das@cognizant.com
