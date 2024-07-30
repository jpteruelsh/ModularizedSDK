//
//  ViewController.swift
//  ModularizediOSDemo
//
//  Created by John Patrick Teruel on 7/19/24.
//

import UIKit
import ModularizedSDK

class ViewController: UIViewController {
    @IBOutlet weak var theLabelLabel: UILabel!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
        
        let greeting = Greeting()
        let greet = greeting.greet();
        
        // This comes from the ModularizedSDK "main" module
        let mm = MainClass(name: "Harrison Ford")
        theLabelLabel.text = mm.greet()
        
        // This comes from the ProfileModule
        let profile = ProfileClass.companion.createProfileClass()
        theLabelLabel.text = profile.name
        
        // This comes from the CoreModule
        let core = CoreClass.companion.createCoreClass()
        theLabelLabel.text = core.name
        let core2 = CoreClass(name:"try")
        theLabelLabel.text = core2.name
        
    }


}

