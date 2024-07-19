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
        
        theLabelLabel.text = greet
    }


}

